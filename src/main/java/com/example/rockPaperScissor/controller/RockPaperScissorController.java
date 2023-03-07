package com.example.rockPaperScissor.controller;

import com.example.rockPaperScissor.common.CustomMessages;
import com.example.rockPaperScissor.common.InputType;
import com.example.rockPaperScissor.entity.InputHandler;
import com.example.rockPaperScissor.processor.DataProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@Slf4j
public class RockPaperScissorController {
    InputHandler input = new InputHandler();

    @RequestMapping("/rock-paper-scissor")
    public ResponseEntity<String> check(){

        System.out.println(CustomMessages.inputOptions);
        int numUserWins = 0;
        int totalGames = 0;

        while(input.getPlayGame()){
            log.info("Match Number: " + totalGames);
            System.out.println(CustomMessages.askUserForInput);

            input.takeInputs();

            if(input.getStartNewGame()) continue;

            System.out.println("Choice you made: " + InputType.valueOf(input.getUserInput()));

            if(!input.getPlayGame()) break;

            System.out.println("Choice computer made: " + InputType.valueOf(input.getComputerInput()));

            DataProcessor resultProcessor = new DataProcessor(input.getUserInput(), input.getComputerInput());
            numUserWins += resultProcessor.findWinner()?1:0;
            totalGames+=1;

            System.out.println("\n\n");
        }

        return new ResponseEntity<>(String.format(CustomMessages.response, totalGames, numUserWins), HttpStatus.OK);
    }
}

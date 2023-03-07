package com.example.rockPaperScissor.entity;

import com.example.rockPaperScissor.common.InputType;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
@Getter
public class InputHandler {
    private int userInput;
    private int computerInput;
    private Boolean playGame = true;
    private Boolean startNewGame = false;

    public void takeInputs(){
        resetValues();
        try{
            computerInput = (int)Math.floor(Math.random()*4);
            Scanner sc = new Scanner(System.in);
            userInput = sc.nextInt();
            log.info("Input user entered: " + userInput);
            InputType.isValidInput(userInput);

            if(InputType.valueOf(userInput)==InputType.QUIT) playGame=false;

        } catch (Exception ex){
            startNewGame = true;
            log.error("Invalid input entered by the user: " + ex.getMessage());
            System.out.println("PLEASE ENTER A VALID INPUT");
        }
    }

    public void resetValues(){
        playGame= true;
        startNewGame= false;
    }

}

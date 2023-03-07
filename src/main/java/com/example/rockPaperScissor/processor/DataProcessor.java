package com.example.rockPaperScissor.processor;

import com.example.rockPaperScissor.common.CustomMessages;
import com.example.rockPaperScissor.common.InputType;
import lombok.extern.slf4j.Slf4j;

import static com.example.rockPaperScissor.common.InputType.*;

@Slf4j
public class DataProcessor {
    InputType userInput;
    InputType computerInput;

    public DataProcessor(int userInput, int computerInput) {
        this.userInput =  InputType.valueOf(userInput);
        this.computerInput =  InputType.valueOf(computerInput);
    }

    public Boolean findWinner(){
        log.info("User Input -> " + userInput + " || Computer Input -> " + computerInput);
        if(userInput==computerInput){
            System.out.println(CustomMessages.tie);
            log.info(CustomMessages.tie);
        }
        else{
            switch(userInput) {
                case ROCK:
                    if (computerInput == SCISSOR){
                        System.out.print(CustomMessages.userWins);
                        log.info(CustomMessages.userWins);
                        return true;
                    }
                    else{
                        System.out.print(CustomMessages.computerWins);
                        log.info(CustomMessages.computerWins);
                    }
                    break;
                case SCISSOR:
                    if (computerInput == PAPER){
                        System.out.print(CustomMessages.userWins);
                        log.info(CustomMessages.userWins);
                        return true;
                    }
                    else{
                        System.out.print(CustomMessages.computerWins);
                        log.info(CustomMessages.computerWins);
                    }
                    break;
                case PAPER:
                    if (computerInput == ROCK){
                        System.out.print(CustomMessages.userWins);
                        log.info(CustomMessages.userWins);
                        return true;
                    }
                    else{
                        System.out.print(CustomMessages.computerWins);
                        log.info(CustomMessages.computerWins);
                    }
                    break;
            }
        }
        return false;
    }
}

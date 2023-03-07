package com.example.rockPaperScissor.common;

import java.util.HashMap;
import java.util.Map;

public enum InputType {
        ROCK(1),
        PAPER(2),
        SCISSOR(3),
        QUIT(4);

        private int value;
        private static Map map = new HashMap<>();

        private InputType(int value) {
            this.value = value;
        }

        static {
            for (InputType inputType : InputType.values()) {
                map.put(inputType.value, inputType);
            }
        }

        public static InputType valueOf(int data) {
            return (InputType) map.get(data);
        }

        public static void isValidInput(int data) throws Exception {
            if(!map.containsKey(data)) throw new Exception("Number entered does not belong to the given choices");
        }

        public int getValue() {
            return value;
        }
}

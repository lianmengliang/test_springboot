package com.springboot.practiceDemo;

public enum TypeEnum {
        VIDEO(1, "视频"), AUDIO(2, "音频"), TEXT(3, "文本"), IMAGE(4, "图像");

        int value;
        String name;

        TypeEnum(int value, String name) {
            this.value = value;
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        public static TypeEnum getByValue(int value) {
            for(TypeEnum typeEnum : TypeEnum.values()) {

                if(typeEnum.value == value) {
                    return typeEnum;
                }
            }
            throw new IllegalArgumentException("No element matches " + value);
        }
    }


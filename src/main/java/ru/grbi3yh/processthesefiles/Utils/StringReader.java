package ru.grbi3yh.processthesefiles.Utils;

import java.util.ArrayList;
import java.util.List;

import static java.awt.event.KeyEvent.*;
import static java.util.Arrays.asList;

public class StringReader {

    public List<List<Integer>> toKeyEvent(String str){
        List<List<Integer>> keyEvents = new ArrayList<>();
        for(char character: str.toCharArray()){
            keyEvents.add(type(character));
        }
        return keyEvents;
    }

    public List<Integer> type(char character) {
        switch (character) {
            case 'a': return asList(VK_A);
            case 'b': return asList(VK_B);
            case 'c': return asList(VK_C);
            case 'd': return asList(VK_D);
            case 'e': return asList(VK_E);
            case 'f': return asList(VK_F);
            case 'g': return asList(VK_G);
            case 'h': return asList(VK_H);
            case 'i': return asList(VK_I);
            case 'j': return asList(VK_J);
            case 'k': return asList(VK_K);
            case 'l': return asList(VK_L);
            case 'm': return asList(VK_M);
            case 'n': return asList(VK_N);
            case 'o': return asList(VK_O);
            case 'p': return asList(VK_P);
            case 'q': return asList(VK_Q);
            case 'r': return asList(VK_R);
            case 's': return asList(VK_S);
            case 't': return asList(VK_T);
            case 'u': return asList(VK_U);
            case 'v': return asList(VK_V);
            case 'w': return asList(VK_W);
            case 'x': return asList(VK_X);
            case 'y': return asList(VK_Y);
            case 'z': return asList(VK_Z);
            case 'A': return asList(VK_SHIFT, VK_A);
            case 'B': return asList(VK_SHIFT, VK_B);
            case 'C': return asList(VK_SHIFT, VK_C);
            case 'D': return asList(VK_SHIFT, VK_D);
            case 'E': return asList(VK_SHIFT, VK_E);
            case 'F': return asList(VK_SHIFT, VK_F);
            case 'G': return asList(VK_SHIFT, VK_G);
            case 'H': return asList(VK_SHIFT, VK_H);
            case 'I': return asList(VK_SHIFT, VK_I);
            case 'J': return asList(VK_SHIFT, VK_J);
            case 'K': return asList(VK_SHIFT, VK_K);
            case 'L': return asList(VK_SHIFT, VK_L);
            case 'M': return asList(VK_SHIFT, VK_M);
            case 'N': return asList(VK_SHIFT, VK_N);
            case 'O': return asList(VK_SHIFT, VK_O);
            case 'P': return asList(VK_SHIFT, VK_P);
            case 'Q': return asList(VK_SHIFT, VK_Q);
            case 'R': return asList(VK_SHIFT, VK_R);
            case 'S': return asList(VK_SHIFT, VK_S);
            case 'T': return asList(VK_SHIFT, VK_T);
            case 'U': return asList(VK_SHIFT, VK_U);
            case 'V': return asList(VK_SHIFT, VK_V);
            case 'W': return asList(VK_SHIFT, VK_W);
            case 'X': return asList(VK_SHIFT, VK_X);
            case 'Y': return asList(VK_SHIFT, VK_Y);
            case 'Z': return asList(VK_SHIFT, VK_Z);
            case '`': return asList(VK_BACK_QUOTE);
            case '0': return asList(VK_0);
            case '1': return asList(VK_1);
            case '2': return asList(VK_2);
            case '3': return asList(VK_3);
            case '4': return asList(VK_4);
            case '5': return asList(VK_5);
            case '6': return asList(VK_6);
            case '7': return asList(VK_7);
            case '8': return asList(VK_8);
            case '9': return asList(VK_9);
            case '-': return asList(VK_MINUS);
            case '=': return asList(VK_EQUALS);
            case '~': return asList(VK_SHIFT, VK_BACK_QUOTE);
            case '!': return asList(VK_EXCLAMATION_MARK);
            case '@': return asList(VK_AT);
            case '#': return asList(VK_NUMBER_SIGN);
            case '$': return asList(VK_DOLLAR);
            case '%': return asList(VK_SHIFT, VK_5);
            case '^': return asList(VK_CIRCUMFLEX);
            case '&': return asList(VK_AMPERSAND);
            case '*': return asList(VK_ASTERISK);
            case '(': return asList(VK_LEFT_PARENTHESIS);
            case ')': return asList(VK_RIGHT_PARENTHESIS);
            case '_': return asList(VK_UNDERSCORE);
            case '+': return asList(VK_PLUS);
            case '\t': return asList(VK_TAB);
            case '\n': return asList(VK_ENTER);
            case '[': return asList(VK_OPEN_BRACKET);
            case ']': return asList(VK_CLOSE_BRACKET);
            case '\\': return asList(VK_BACK_SLASH);
            case '{': return asList(VK_SHIFT, VK_OPEN_BRACKET);
            case '}': return asList(VK_SHIFT, VK_CLOSE_BRACKET);
            case '|': return asList(VK_SHIFT, VK_BACK_SLASH);
            case ';': return asList(VK_SEMICOLON);
            case ':': return asList(VK_SHIFT,VK_SEMICOLON);
            case '\'': return asList(VK_QUOTE);
            case '"': return asList(VK_QUOTEDBL);
            case ',': return asList(VK_COMMA);
            case '<': return asList(VK_SHIFT, VK_COMMA);
            case '.': return asList(VK_PERIOD);
            case '>': return asList(VK_SHIFT, VK_PERIOD);
            case '/': return asList(VK_SLASH);
            case '?': return asList(VK_SHIFT, VK_SLASH);
            case ' ': return asList(VK_SPACE);
            default:
                throw new IllegalArgumentException("Cannot type character " + character);
        }
    }

}

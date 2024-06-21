package com.soa.novelcreatorcore.helper;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Хэлпер для генерации/валидации пароля
 */
public class PasswordUtil {
    /**
     * Разрешенные спец.символы при генерации/валидации пароля
     */
    public static final String ALLOWED_SPECIAL_SYMBOLS = "!@#*;_-,:.";

    /**
     * Новый паттерн валидации пароля админов
     * <p>
     * Пояснение:
     * <p>
     * (?=.*[0-9]) - строка содержит хотя бы одно число;
     * (?=.*[!@#%*;_\-,№:.]) - строка содержит хотя бы один спецсимвол;
     * (?=.*[a-z]) - строка содержит хотя бы одну латинскую букву в нижнем регистре;
     * (?=.*[A-Z]) - строка содержит хотя бы одну латинскую букву в верхнем регистре;
     * (?=.*[A-Z])[0-9a-zA-Z!!@#%*;_\-,№:.]{8,20} - строка состоит не менее, чем из 16 вышеупомянутых символов и не более 20.
     */
    public static final String PASSWORD_PATTERN_FOR_ADMIN = "(?=.*[0-9])(?=.*[!@#*;_\\-,:.])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#*;_\\-,:.]{16,20}";

    /**
     * Новый паттерн валидации пароля Юзеров
     * <p>
     * Пояснение:
     * <p>
     * (?=.*[0-9]) - строка содержит хотя бы одно число;
     * (?=.*[!@#$%^&*();'<>?_\-+=/|.\\,№":]) - строка содержит хотя бы один спецсимвол;
     * (?=.*[a-z]) - строка содержит хотя бы одну латинскую букву в нижнем регистре;
     * (?=.*[A-Z]) - строка содержит хотя бы одну латинскую букву в верхнем регистре;
     * (?=.*[A-Z])[0-9a-zA-Z!@#$%^&*();'<>?_\-+=/|.\\,№":]{8,20} - строка состоит не менее, чем из 8 вышеупомянутых символов и не более 20.
     */
    public static final String PASSWORD_PATTERN_FOR_USER = "(?=.*[0-9])(?=.*[!@#*;_\\-,:.])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#*;_\\-,:.]{8,20}";

    /**
     * Интервал размеров пароля для юзера
     * <p>
     * Размер пароля выбирается из этого списка случайным образом
     */
    private final static int[] allowedIntervalPasswordSizeForUser = new int[]{8, 9, 10, 11, 12, 13, 14, 15};

    /**
     * Интервал размеров пароля для админа
     * <p>
     * Размер пароля выбирается из этого списка случайным образом
     */
    private final static int[] allowedIntervalPasswordSizeForAdmin = new int[]{16, 17, 18, 19, 20};

    /**
     * Enum для выбора сложности пароля
     * <p>
     * На выбор две сложности:
     * GENERATE_PASSWORD_FOR_ADMIN - для администратора: только латиница с заглавными и прописными буквами, цифрами, спец.символами, размер от 16 до 20
     * GENERATE_PASSWORD_FOR_USER - для пользователей: только латиница, с заглавными и прописными буквами, спец.символами, размер от 8 до 20
     * <p>
     * Используется только в методах PasswordUtil.generatePassword(...);
     */
    public enum PasswordDifficulty {
        DIFFICULTY_ADMIN,
        DIFFICULTY_USER
    }

    /**
     * Функция скрывает реализацию генерации пароля.
     * Размер пароля будет выбран рандомно из интервала исходя из параметра PasswordDifficulty
     *
     * @param passwordDifficulty - значение enum'a, указывающего сложность пароля
     * @return сгенерированный пароль разной сложности.
     */
    public static String generatePassword(PasswordDifficulty passwordDifficulty) {
        Random random = new Random();
        int indexInterval;
        int passwordSize;
        if (PasswordDifficulty.DIFFICULTY_ADMIN.equals(passwordDifficulty)) {
            indexInterval = random.nextInt(allowedIntervalPasswordSizeForAdmin.length);
            passwordSize = allowedIntervalPasswordSizeForAdmin[indexInterval];
        } else if (PasswordDifficulty.DIFFICULTY_USER.equals(passwordDifficulty)) {
            indexInterval = random.nextInt(allowedIntervalPasswordSizeForUser.length);
            passwordSize = allowedIntervalPasswordSizeForUser[indexInterval];
        } else {
            throw new RuntimeException("Invalid passwordDifficult");
        }
        return generatePassword(passwordSize, random);
    }

    /**
     * Функция скрывает реализацию генерации пароля с возможностью задания размера пароля.
     *
     * @param from - минимальная длина пароля
     * @param to   - максимальная длина пароля
     * @return сгенерированный пароль
     */
    public static String generatePassword(int from, int to) {
        Random random = new Random();
        int passwordSize = from + random.nextInt(to - from + 1);
        return generatePassword(passwordSize, random);
    }

    /**
     * Метод валидации пароля Юзера
     *
     * @param password           - пароль
     * @param passwordDifficulty - параметр выбора валидации.
     * @return - true/false
     */
    public static boolean validatePassword(String password, PasswordDifficulty passwordDifficulty) {
        if (PasswordDifficulty.DIFFICULTY_USER.equals(passwordDifficulty)) {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN_FOR_USER);
            return pattern.matcher(password).matches();
        } else if (PasswordDifficulty.DIFFICULTY_ADMIN.equals(passwordDifficulty)) {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN_FOR_ADMIN);
            return pattern.matcher(password).matches();
        } else {
            throw new RuntimeException("Invalid passwordDifficult");
        }
    }

    /**
     * Генерация пароля для Администратора
     *
     * @param passwordSize - размер пароля
     * @param random       - Класс-рандомайзер
     * @return - Сгенерированный пароль
     */
    private static String generatePassword(int passwordSize, Random random) {
        List<Character> characters = new ArrayList<>();
        char next;
        int range;

        StringBuilder password = new StringBuilder(passwordSize);

        int bound = passwordSize / 4;

        int countOfSpecialCharacters = 1 + random.nextInt(bound);
        int countOfDigits = 1 + random.nextInt(bound);

        int countLetters = passwordSize - (countOfSpecialCharacters + countOfDigits);

        int countOfUppercaseLetters = 1 + random.nextInt(countLetters / 2);
        int countOfLowercaseLetters = countLetters - countOfUppercaseLetters;

        for (int i = 0; i < passwordSize; i++) {
            if (countOfSpecialCharacters != 0) {

                characters.add(ALLOWED_SPECIAL_SYMBOLS.charAt(random.nextInt(ALLOWED_SPECIAL_SYMBOLS.length())));
                --countOfSpecialCharacters;
                continue;
            }
            if (countOfDigits != 0) {
                next = '0';
                range = 10;
                characters.add((char) (random.nextInt(range) + next));
                --countOfDigits;
                continue;
            }
            if (countOfLowercaseLetters != 0) {
                next = 'a';
                range = 26;
                characters.add((char) (random.nextInt(range) + next));
                --countOfLowercaseLetters;
                continue;
            }
            if (countOfUppercaseLetters != 0) {
                next = 'A';
                range = 26;
                characters.add((char) (random.nextInt(range) + next));
                --countOfUppercaseLetters;
            }
        }
        Collections.shuffle(characters);
        characters.forEach(password::append);
        return password.toString();
    }

}

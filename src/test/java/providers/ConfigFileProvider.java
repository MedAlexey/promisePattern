package providers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ConfigFileProvider {

    private String configFileName;

    public ConfigFileProvider(String fileName) {
        this.configFileName = fileName;
    }

    public String getLogin() {
        return getContentByKeyWord("login");
    }

    public String getPassword() {
        return getContentByKeyWord("password");
    }

    // получение из конфигурационного файла адреса группы, в которой пользователь состоит
    public String getGroupInWichUserIsMember() {
        return getContentByKeyWord("groupInWhichUserIsMember");
    }

    // получение из конфигурационного файла адреса группы, в которой пользователь не состоит
    public String getGroupInWichUserIsNotMember() {
        return getContentByKeyWord("groupInWhichUserIsNotMember");
    }

    // получение из конфигурационного файла адреса группы, в которой пользователь - администратор
    public String getGroupInWichUserIsAdmin() {
        return getContentByKeyWord("groupInWhichUserIsAdministrator");
    }

    public String getGroupInWhichUserWaitingForConfirmation() {
        return getContentByKeyWord("groupInWhichUserWaitingForConfirmation");
    }

    // Поиск в конфигурационном файле значений по ключевому слову
    // Вид конфигурационного файла:
    //   ключевое слово = значение
    private String getContentByKeyWord(String keyWord) {
        String result = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(configFileName));
            String line = reader.readLine();
            while (line != null && !line.split("=")[0].trim().equals(keyWord)) {
                line = reader.readLine();
            }
            result = (line == null) ? "" : line.split("=")[1].trim();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

}


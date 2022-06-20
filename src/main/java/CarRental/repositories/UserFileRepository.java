package CarRental.repositories;

import CarRental.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class UserFileRepository implements Repository<User>{
    Path path = Paths.get("resources","users.json");

    private void checkPath(){
        try {
            if (!Files.exists(path)) {
                if (!Files.isDirectory(Paths.get("resources"))) {
                    Files.createDirectory(Path.of("resources"));
                    Files.createFile(Path.of("resources", "users.json"));
                }
                if (!Files.exists((path))) {
                    Files.createFile(Path.of("resources", "users.json"));
                }
                String s = "[]";
                Files.write(Path.of("resources", "users.json"),s.getBytes(StandardCharsets.UTF_8));
            }
        } catch (java.io.IOException e){
            e.printStackTrace();
        }
    }

    private boolean writeToJson(Collection<User> users){
        ObjectMapper objectMapper = new ObjectMapper();
        String s;
        try {
            s = objectMapper.writeValueAsString(users);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return false;
        }
        try {
            Files.write(path,s.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean add(User user) {
        checkPath();
        List<User> carsList = getAll();
        TreeSet<User> users = new TreeSet<>();
        users.addAll(carsList);
        users.add(user);

        return writeToJson(users);
    }

    @Override
    public List<User> getAll() {
        checkPath();
        try {
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(
                    mapper.readValue(Paths.get("resources", "users.json").toFile(),
                            User[].class));
        } catch (Exception ex) {
            ex.printStackTrace();
            return Arrays.asList();
        }
    }


    public boolean edit(User user) {
        checkPath();
        if(!remove(user)) return false;
        return add(user);

    }

    public boolean remove(User user) {
        checkPath();

        List<User> alunosList = getAll();
        TreeSet<User> users = new TreeSet<>();
        users.addAll(alunosList);
        users.remove(user);
        return writeToJson(users);
    }
}

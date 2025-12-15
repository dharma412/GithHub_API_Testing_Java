package github_api.utility;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtility {

    public static Map<String, String> generatePathParams(String owner, String reponame) {
        return Stream.of(new String[][]{
                        {"owner", owner},
                        {"reponame", reponame},
                }).filter(values -> Optional.ofNullable(values[1]).isPresent())
                .collect(Collectors.toMap(data -> data[0], data -> data[1]));

    }
}

package services;

import java.util.*;
import java.util.stream.Stream;

public class BusService {

    public static String calculateBussize(String input) {
        Integer[] groups = Stream.of(input.split(",")).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        int maxgroup = Collections.max(Arrays.asList(groups));
        int maxsize = Stream.of(groups).parallel().reduce(0, Integer::sum);
        StringBuilder output = new StringBuilder();

        for(int size = maxgroup ; size <=maxsize ; size++){
            if(maxsize==size) {
                output.append(size);
            }else {
                if(maxsize%size==0){
                    int index=0;
                    int tmp=0;

                    while((tmp < size || tmp == size) && index < (groups.length)){
                        tmp += groups[index];
                        if (tmp == size){
                            tmp= 0;
                        }
                        index++;
                        if (index == (groups.length - 1)){
                            output.append(size).append(", ");
                        }
                    }
                }
            }
        }
        return output.toString();
    }
}


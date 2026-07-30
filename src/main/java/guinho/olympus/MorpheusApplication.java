package guinho.olympus;

import guinho.olympus.commands.MorpheusCommand;
import guinho.olympus.commands.SimulateCommand;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MorpheusApplication  {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MorpheusApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }


}

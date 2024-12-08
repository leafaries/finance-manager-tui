package com.leafaries.tui;

import com.leafaries.tui.controller.LoginController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class Application {

    private final LoginController loginController;

    // TODO: Refactor classes to be more loosely-coupled, so:
    //       - LoginController would hold a ViewManager and a LoginService
    //         we would set in a Controller all the event listeners to our instance viewManger methods
    //       - Also if we're interacting with some api, we should be calling a interface gateway, and then a specific
    //         implementation of that would do the actual api requests. (also it'd would have a gateway in the name)
    public void run() {
        log.info("Starting application");
        loginController.run();
        log.info("Ending application");
    }

}

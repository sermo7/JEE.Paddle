package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    UserResourceIT.class, 
    TokenResourceIT.class, 
    CourtResourceIT.class,
})
public class AllControllerIntegrationTests {

}

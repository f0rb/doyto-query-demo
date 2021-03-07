package win.doyto.query.demo.module.role;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.RequestBuilder;
import win.doyto.query.demo.DemoApplicationTests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 * RoleControllerTest
 *
 * @author f0rb on 2021-03-05
 */
@SuppressWarnings("squid:S1192")
class RoleControllerTest extends DemoApplicationTests {

    @Test
    void getById() throws Exception {
        performAndExpectSuccess(get("/role/1"))
                .andExpect(jsonPath("$.data.roleName").value("admin"))
        ;
    }

    @Test
    void queryByRoleName() throws Exception {
        performAndExpectSuccess(get("/role/?roleNameLike=vip&pageSize=2&sort=id,desc"))
                .andExpect(jsonPath("$.data.list").isArray())
                .andExpect(jsonPath("$.data.list.size()").value(2))
                .andExpect(jsonPath("$.data.list[0].id").value(4))
                .andExpect(jsonPath("$.data.total").value(3))
        ;
    }

    @Test
    @Rollback
    void add() throws Exception {
        String content = "{\"roleName\":\"test5\",\"roleCode\":\"VIP5\",\"valid\":true}";
        RequestBuilder requestBuilder = post("/role/").content(content).contentType(MediaType.APPLICATION_JSON);
        performAndExpectSuccess(requestBuilder);
        performAndExpectSuccess(get("/role/?pageSize=1"))
                .andExpect(jsonPath("$.data.total").value(6))
        ;
    }

    @Test
    @Rollback
    void patchRole() throws Exception {
        RequestBuilder requestBuilder = patch("/role/2").content("{\"roleName\":\"new role\"}").contentType(MediaType.APPLICATION_JSON);
        performAndExpectSuccess(requestBuilder);
        performAndExpectSuccess(get("/role/2"))
                .andExpect(jsonPath("$.data.roleName").value("new role"))
        ;
    }

    @Test
    @Rollback
    void updateRole() throws Exception {
        RequestBuilder requestBuilder = put("/role/3").content("{\"roleName\":\"test3\",\"roleCode\":\"TEST3\"}").contentType(MediaType.APPLICATION_JSON);
        performAndExpectSuccess(requestBuilder);
        performAndExpectSuccess(get("/role/3"))
                .andExpect(jsonPath("$.data.roleName").value("test3"))
                .andExpect(jsonPath("$.data.roleCode").value("TEST3"))
        ;
    }

    @Test
    @Rollback
    void deleteById() throws Exception {
        performAndExpectSuccess(delete("/role/1"));
        performAndExpectSuccess(get("/role/?pageSize=1"))
                .andExpect(jsonPath("$.data.total").value(4))
                .andExpect(jsonPath("$.data.list[0].id").value(2))
        ;
    }

    @Test
    @Rollback
    void batch() throws Exception {
        performAndExpectSuccess(post("/role/").content("[{\"roleName\":\"vip4\",\"roleCode\":\"VIP4\"},{\"roleName\":\"vip5\",\"roleCode\":\"VIP5\"}]").contentType(MediaType.APPLICATION_JSON));
        performAndExpectSuccess(get("/role/?pageSize=5"))
                .andExpect(jsonPath("$.data.total").value(7))
        ;
    }

    @Test
    void pageStartFromOne() throws Exception {
        performAndExpectSuccess(get("/role/?pageNumber=1&pageSize=2"))
                .andExpect(jsonPath("$.data.list[0].id").value(1))
        ;
    }

    @Test
    void checkPageStartFromOneByBuilder() throws Exception {
        performAndExpectSuccess(get("/role/checkPage?pageNumber=1"))
                .andExpect(jsonPath("$.data[0].id").value(1))
        ;
    }

}
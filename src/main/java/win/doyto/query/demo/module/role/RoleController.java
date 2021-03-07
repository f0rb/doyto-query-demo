package win.doyto.query.demo.module.role;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.doyto.query.web.controller.AbstractIQEEController;
import win.doyto.query.web.response.JsonBody;

import java.util.List;

@JsonBody
@RestController
@RequestMapping("role")
public class RoleController extends AbstractIQEEController<RoleEntity, Integer, RoleQuery> {

    @GetMapping("checkPage")
    public List<RoleEntity> get(int pageNumber) {
        return query(RoleQuery.builder().pageNumber(pageNumber).build());
    }

}

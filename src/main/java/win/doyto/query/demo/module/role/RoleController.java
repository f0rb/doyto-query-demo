package win.doyto.query.demo.module.role;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import win.doyto.query.web.controller.AbstractIQEEController;

@RestController
@RequestMapping("role")
public class RoleController extends AbstractIQEEController<RoleEntity, Integer, RoleQuery> {
}

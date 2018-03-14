package com.kh013j;

import com.kh013j.model.domain.Role;
import com.kh013j.model.service.interfaces.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleServiceImplTest {
    @Autowired
    private RoleService roleService;

    @Test(expected = Exception.class)
    public void tryToCreate() {
        roleService.create(new Role());
    }


    @Test(expected = Exception.class)
    public void tryToDelete(){
        roleService.delete(-1L);
    }


    @Test
    public void findRoleByName() {
        // create in before
        String name = "Porter";
        Role role = new Role();
        role.setName(name);

        Role createdRole= roleService.create(role);

        Role foundRole = roleService.findByName(name);

        assertEquals(foundRole, createdRole);
    }

    public void tryToFindRoleByName(){
        Assert.assertNull(roleService.findByName(""));
    }

    @Test
    public void findAll() {
        Assert.assertTrue(roleService.findAll().size() >= 4);
    }
}
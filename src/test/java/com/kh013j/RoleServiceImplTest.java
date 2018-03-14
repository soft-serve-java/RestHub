package com.kh013j;

import com.kh013j.model.domain.Category;
import com.kh013j.model.domain.Role;
import com.kh013j.model.exception.CategoryNotFound;
import com.kh013j.model.service.interfaces.CategoryService;
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

    @Test
    public void create() {
        Role role = new Role();
        role.setName("Schweizer");

        Role createdRole = roleService.create(role);
        assertEquals(createdRole.getName(), role.getName());
    }

    @Test(expected = Exception.class)
    public void tryToCreate() {
        roleService.create(new Role());
    }

    @Test
    public void delete() {
        Role role = new Role();

        Role createdRole = roleService.create(role);

        Role deletedRole = roleService.delete(createdRole.getId());

        Assert.assertNull(roleService.findByName(deletedRole.getName()));
    }

    @Test(expected = Exception.class)
    public void tryToDelete(){
        roleService.delete(-1L);
    }

    @Test
    public void update() {
        String name = "noName";

        Role role  = new Role();
        role.setName(name);

        roleService.create(role);

        Role foundRole = roleService.findByName(name);
        foundRole.setName("Driver");

        Role updatedRole = roleService.update(foundRole);

        Role foundUpdatedRole = roleService.findByName(updatedRole.getName());

        assertEquals(foundRole, foundUpdatedRole);
    }

    @Test
    public void tryToUpdate() {
        String name = "CEO";

        Role role = new Role();
        Role updatedRole= roleService.update(role);

        assertEquals(updatedRole.getName(), name);
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
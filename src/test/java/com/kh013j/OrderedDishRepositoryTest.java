package com.kh013j;

import com.kh013j.model.domain.Order;
import com.kh013j.model.domain.Role;
import com.kh013j.model.domain.User;
import com.kh013j.model.exception.DishNotFound;
import com.kh013j.model.repository.OrderRepository;
import com.kh013j.model.service.CaffinoApplicationTestConfiguration;
import com.kh013j.model.service.interfaces.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.context.ContextLoader;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;
import java.sql.*;

import static com.sun.org.apache.xerces.internal.util.FeatureState.is;
import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V10;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderedDishRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    private Order order = new Order();

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        CaffinoApplicationTestConfiguration caffinoApplicationTestConfiguration = new CaffinoApplicationTestConfiguration();
        caffinoApplicationTestConfiguration.startPostgres();
        // get embedded database.postgres bean from application context

        //create db test


        // starting Postgres
/*       final EmbeddedPostgres database.postgres = new EmbeddedPostgres(V10);
// predefined data directory
// final EmbeddedPostgres database.postgres = new EmbeddedPostgres(V9_6, "/path/to/predefined/data/directory");
        final String url = database.postgres.start("localhost", 5433, "test", "cat", "1234");

// connecting to a running Postgres and feeding up the database
       /* final Connection conn = DriverManager.getConnection(url);

        //  conn.createStatement().execute("CREATE TABLE films (code char(5));");
        conn.createStatement().execute("INSERT INTO films VALUES ('movie');");

        // performing some assertions
        final Statement statement = conn.createStatement();
        Assert.isTrue(statement.execute("SELECT * FROM films;"));

        // close db connection
        conn.close();
// stop Postgres
        database.postgres.stop();*/
    }

    @Test
    public void isOrderAdded() {
        Assert.notNull(orderRepository.save(order));
    }

    @Test
    public void isOrderDeleted() throws DishNotFound {
        Assert.notNull(orderService.delete(1L));
    }

    @Test
    public void isOrdersEqual() {
        User user = new User(1, "amely.honey@gmail.com", "Kitten", "fghj", new Role(1, "Admin"));

        Timestamp time = new Timestamp(22L);

        order = new Order(2, time, user, 1, false, null);
        orderService.create(order);

        Assert.isTrue(order.equals(orderRepository.findOne(2L)));
    }
}

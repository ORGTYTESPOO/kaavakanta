/*
 * Kyselyt Java Persistence Apin kautta

Java Persistence APIn kautta tehdyt kyselyt eivät ole natiivia SQL:ää, vaan seuraavat JPQL-määritelmää (Java Persistence Query Language), joka kuitenkin muistuttaa SQL:ää. JPQL-kielestä löytyy lisää tietoa osoitteesta http://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html.



                <pre>
                    <p th:each="index : ${suunnittelualue}">
                        <option th:text="${index}"> th:text="${index}" </option>
                    </p>
                </pre>

 <form th:action="@{/}" method="POST">
            <!-- valintalista 1 -->
                <select name="var1">
                    <p th:each="index : ${suunnittelualue}">
                        <option th:text="${index}"> th:text="${index}" </option>
                    </p>
                </select>

            <!-- valintalista 2 
                <select name="var2">
                    <p th:each="index : ${controllerin_lahettama_lista_attribuutti}">
                        <option th:text="${index}"> th:text="${index}" </option>
                    </p>
                </select>
            
            -->
            
            <button type="submit">Lähetä kaavarekisteriin</button>

        </form>
*/
package ksk;

/**
 *
 * @author saara
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }
}

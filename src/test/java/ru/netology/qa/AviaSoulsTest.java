package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    TicketTimeComparator timeComparator = new TicketTimeComparator();

    @Test
    public void ShouldCompareFirstPriceBelow() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                3_000,
                1850,
                2100);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                5_000,
                1850,
                2100);

        Assertions.assertEquals(-1, ticket1.compareTo(ticket2));
    }

    @Test
    public void ShouldCompareFirstPriceAbove() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                4_000,
                1850,
                2100);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                2_000,
                1850,
                2100);

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
    }

    @Test
    public void ShouldCompareSamePrice() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                3_000,
                1850,
                2100);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1850,
                2100);

        Assertions.assertEquals(0, ticket1.compareTo(ticket2));
    }

    @Test
    public void ShouldCompareFirstTimeBelow() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                5_000,
                1850,
                2020);
        Ticket ticket2 = new Ticket("Москва",
                "Калининград",
                3_000,
                1230,
                1430);

        Assertions.assertEquals(-1, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    public void ShouldCompareFirstTimeAbove() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                3_000,
                1230,
                1430);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                5_000,
                1850,
                2020);

        Assertions.assertEquals(1, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    public void ShouldCompareSameTime() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                3_000,
                1910,
                2110);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);

        Assertions.assertEquals(0, timeComparator.compare(ticket1, ticket2));
    }
}

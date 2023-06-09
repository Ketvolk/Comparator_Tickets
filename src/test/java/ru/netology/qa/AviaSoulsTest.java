package ru.netology.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {

    TicketTimeComparator timeComparator = new TicketTimeComparator();
    AviaSouls aviaSouls = new AviaSouls();

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
    public void ShouldSortByPriceOneThree() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                2_000,
                1800,
                2000);
        Ticket ticket2 = new Ticket("Москва",
                "Калининград",
                3_000,
                1230,
                1430);
        Ticket ticket3 = new Ticket("Москва",
                "Сочи",
                4_000,
                1000,
                1300);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortBySamePrices() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                3_000,
                1800,
                2000);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1230,
                1430);
        Ticket ticket3 = new Ticket("Москва",
                "Сочи",
                3_000,
                1000,
                1300);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByPriceTwoOne() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                5_000,
                1850,
                2020);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1230,
                1430);
        Ticket ticket3 = new Ticket("Москва",
                "Калининград",
                3_000,
                1850,
                2100);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldCompareFirstTimeBelow() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                5_000,
                1800,
                2000);
        Ticket ticket2 = new Ticket("Москва",
                "Калининград",
                3_000,
                1200,
                1430);

        Assertions.assertEquals(-1, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    public void ShouldCompareFirstTimeAbove() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1430);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                5_000,
                1800,
                2000);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldCompareSameTime() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                3_000,
                1900,
                2100);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);

        Assertions.assertEquals(0, timeComparator.compare(ticket1, ticket2));
    }

    @Test
    public void ShouldSortByTimeTwoOne() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                2_000,
                1800,
                2030);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);
        Ticket ticket3 = new Ticket("Москва",
                "Калининград",
                3_000,
                1850,
                2100);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByTimeOneTwoThree() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                2_000,
                1800,
                1930);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);
        Ticket ticket3 = new Ticket("Москва",
                "Сочи",
                3_000,
                1000,
                1300);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortBySameTime() {
        Ticket ticket1 = new Ticket("Москва",
                "Сочи",
                2_000,
                1800,
                2000);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);
        Ticket ticket3 = new Ticket("Москва",
                "Сочи",
                3_000,
                1000,
                1200);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSortByTimeTwoThree() {
        Ticket ticket1 = new Ticket("Москва",
                "Калининград",
                2_000,
                1800,
                2000);
        Ticket ticket2 = new Ticket("Москва",
                "Сочи",
                3_000,
                1200,
                1400);
        Ticket ticket3 = new Ticket("Москва",
                "Сочи",
                3_000,
                1000,
                1230);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}

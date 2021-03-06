package com.matthew.checkout.checkoutcomponent;

import com.matthew.checkout.checkoutcomponent.domain.Item;
import com.matthew.checkout.checkoutcomponent.domain.PriceCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorTest {

    private Item item;

    private List<Item> itemList;

    private PriceCalculator calc;

    @Before
    public void setUp() {
        item = new Item();
        item.setItemName("D");
        itemList = new ArrayList<>();
        itemList.add(item);
        calc = new PriceCalculator(itemList);
    }

    @Test
    public void quantityOfItemTest() {
        double returnedQuantity = calc.quantityOfItem("D");
        assertEquals(1.0, returnedQuantity, 0);
    }

    @Test
    public void determineDiscountForOneItemDTest() {
        calc.determineDiscount();
        assertEquals(0.0, calc.getDiscount(), 0.0);
    }

    @Test
    public void determineDiscountForFiveItemsDTest() {
        itemList = Arrays.asList(item, item, item, item, item);
        calc = new PriceCalculator(itemList);
        calc.determineDiscount();
        assertEquals(22.5, calc.getDiscount(), 0.0);
    }
/*
    @Test
    public void calculateTotalPriceTest() {
        calc.calculateTotalPrice();
        assertEquals(50.0, calc.getTotalPrice(), 0.0);
    }
*/
}

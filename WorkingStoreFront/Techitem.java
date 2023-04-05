public class Techitem extends Doohickey {
    Techitem (String name) {
        super("Tech item", name);
    }
    @Override
    long setSalePrice() {
        salePrice = techSalePrice();
        return salePrice;
    }
   
    long techSalePrice() {
        // more consistent increments off
        // 0 15% off, 1 10% off, 2-3 not % off
        int rand = r.nextInt(4);
        if (rand == 0) {
            return Math.round(price * 0.85);
        } else if (rand == 1) {
            return Math.round(price * 0.90);
        } else {
            return price;
        }
    }

    }



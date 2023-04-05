public class RealEstateItem extends Doohickey {

    RealEstateItem(String name) {
        super("Real Estate", name);
    }

    // this annotation, @Override, shows that you understand that 
    // the Doohickey's setSalePrice() 'default' function won't be called 
    // for RealEstateItems, but rather this one. 
    @Override
    long setSalePrice() {
        salePrice = realEstateSalePrice();
        return salePrice;
    }

    // TODO: don't need to put this in a separate method anymore, 
    // can just put it directly in the overriden method! 
    long realEstateSalePrice() {
        // 4-17% off during the winter (1/4 of the time)
        int rand = r.nextInt(52);
        if (rand < 4 || rand > 17) {
            return price;
        } else {
            return (int) Math.round(price * (100.0 - rand) / 100.0);
        }
    }
    
}

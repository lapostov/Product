public class ProductRepository {

    private Product[] items = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = product;
        items = tmp;
    }

    public Product[] removeById(int removeId) throws NotFoundException {
        if (findById(removeId) == null) {

            throw new NotFoundException("Element with id: " + removeId + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product product : items) {
            if (product.getId() != removeId) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            items = tmp;
        }
        return items;
    }


    public Product[] removeByPrice(int removePrice) {
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product product : items) {
            if (product.getPrice() != removePrice) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            items = tmp;
        }
        return items;
    }


    public Product[] removeByName(String removeName) {
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product product : items) {
            if (product.getName() != removeName) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
            items = tmp;
        }
        return items;
    }

    public Product[] findAll() {
        return items;
    }

    public Product findById(int removeId) {
        Product result = null;
        for (Product product : items) {
            if (product.getId() == removeId) {
                result = product;
                break;
            }
        }
        return result;
    }

}
export class Product {
    quantity: number;
    name: string;
    price: number;
    pictureUrl: string;

     constructor(id: number, name: string, price: number, pictureUrl: string) {
      this.quantity = id;
      this.name = name;
      this.price = price;
      this.pictureUrl = pictureUrl;
     }
}

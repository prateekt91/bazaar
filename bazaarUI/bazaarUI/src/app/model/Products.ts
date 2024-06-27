export class Products {

   id: string;
   name: string;
   description: string;
   price: number;
   category: string;
   stock: number;
   createdAt: Date;
   imageUrl: string;

   constructor(id: string, name: string, description: string, price: number,
               category: string, stock: number, createdAt: Date, imageUrl: string) {
     this.id = id;
     this.name = name;
     this.description = description;
     this.price = price;
     this.category = category;
     this.createdAt = new Date();
     this.stock = stock;
     this.imageUrl = imageUrl;
   }
}

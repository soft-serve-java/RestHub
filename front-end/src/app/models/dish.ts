import {Category} from "./category";
import {Image} from "./image";
import {Tag} from "./tag";

export class Dish {
   id: number;
   name: string;
   description: string;
   weight: number;
   calories: number;
   preparingtime: number;
   price: number;
   category: Category;
   images: Image[];
   tags: Tag[];
   availability: boolean;

   public toString(): String{
     return "Dish: id" + this.id + ", name" + this.name + ", description: " + this.description +
       ", weight: " + this.weight + ", calories: " + this.calories + ", preparingTime: " +
       this.preparingtime + ", price: " + this.price + ", category: " + this.category +
       ", images: " + this.images + " tags: " + this.tags + ", availability: " + this.availability;
   }
}

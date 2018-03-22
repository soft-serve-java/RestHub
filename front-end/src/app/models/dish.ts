import {Category} from "./category";
import {Image} from "./image";

export class Dish {
  id: number;
  private name: string;
  private description: string;
  private weight: number;
  private calories: number;
  private preparingtime: number;
  private price: number;
  private category: Category
  private images: Image[];
  private availability: boolean;
}

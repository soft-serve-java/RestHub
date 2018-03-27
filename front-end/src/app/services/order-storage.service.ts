import {Inject, Injectable} from '@angular/core';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";

@Injectable()
export class OrderStorageService {

  private order = [];

  private dishes = [];

  set orderMap(value) {
    this.order = value;
    this.storage.set('orderMap', value);
  }

  get orderMap() {
    return this.storage.get('orderMap');
  }

  set orderDishes(value) {
    this.dishes = value;
    this.storage.set('orderDishes', value);
  }

  get orderDishes() {
    return this.storage.get('orderDishes');
  }

  removeStorage(){
    this.storage.remove('orderMap');
    this.storage.remove("orderDishes");
    this.order = [];
    this.dishes = [];
  }

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

}

import {Inject, Injectable} from '@angular/core';
import {LOCAL_STORAGE, WebStorageService} from "angular-webstorage-service";

@Injectable()
export class TableStorageService {

  private tableNumber: number;

  set table(value){
    this.tableNumber = value;
    this.storage.set("tableNumber",value);
  }

  get table(){
    if (this.storage.get("tableNumber") == null){
      return 0;
    }
    return this.storage.get("tableNumber");
  }

  constructor(@Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

}

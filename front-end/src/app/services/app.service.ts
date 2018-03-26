import {Injectable, Inject} from '@angular/core';
import {HttpClient,} from '@angular/common/http';
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';


import {Category} from '../models/category'

@Injectable()
export class AppService {
  constructor(@Inject('API_URL') private api: string, private http:HttpClient,
              @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  doPOSTonCallWaiter(tableNumber:number) {
    return this.http.post(this.api + 'callWaiterClient', tableNumber);
  }
  getCategories(): Category[]{
    let categories = this.storage.get("categories");
    if (categories == null){
      this.http.get<Category[]>(this.api + 'category/all').toPromise().then(res=>{
        this.storage.set("categories", res);
        return res;
      });
    }else {
      return categories;
    }
  }

}

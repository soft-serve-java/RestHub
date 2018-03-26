import {Injectable, Inject} from '@angular/core';
import {HttpClient, HttpParams,} from '@angular/common/http';
import {LOCAL_STORAGE, WebStorageService} from 'angular-webstorage-service';


import {Category} from '../models/category'

@Injectable()
export class AppService {
  constructor(@Inject('API_URL') private api: string, private http:HttpClient,
              @Inject(LOCAL_STORAGE) private storage: WebStorageService) { }

  doPOSTonCallWaiter(tableNumber:number) {
    console.log(this.api + 'callWaiterClient');
    const params = new HttpParams()
      .set('table', String(tableNumber));
    return this.http.post(this.api + 'callWaiterClient', {table:tableNumber}, {params: params}).toPromise().then(rer=>console.log(rer));
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

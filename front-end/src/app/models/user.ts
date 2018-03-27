import {Role} from "./role";

export class User {
  id: number;
  username: string;
  private password: string;
  private name: string;
  private confirmationtoken: boolean;
  private enabled: boolean;
  private roles: Role[];
  private avatar: string;


  constructor(login:string, email:string, password:string ){
    this.username = email;
    this.name = login;
    this.password = password;

  }
}

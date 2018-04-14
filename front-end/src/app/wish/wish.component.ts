import {Component, EventEmitter, Inject, Input, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-wish',
  templateUrl: './wish.component.html',
  styleUrls: ['./wish.component.css']
})
export class WishComponent implements OnInit {

  public content: String;

  onOk = new EventEmitter();

  constructor(public dialogRef: MatDialogRef<WishComponent>) { }

  ngOnInit() {
  }

}

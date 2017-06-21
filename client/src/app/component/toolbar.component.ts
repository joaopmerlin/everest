import {Component, Input} from '@angular/core';
import {MdSidenav} from "@angular/material";

@Component({
  selector: 'app-toolbar',
  templateUrl: '../view/toolbar.component.html'
})
export class ToolbarComponent {

  @Input('sidenav')
  sidenav: MdSidenav;

}

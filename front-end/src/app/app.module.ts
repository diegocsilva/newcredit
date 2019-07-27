import { ProposalService } from './services/proposal/proposal.service';
import { FooterComponent } from './components/shared/footer/footer.component';
import { ContentComponent } from './components/shared/content/content.component';
import { MainpanelComponent } from './components/shared/mainpanel/mainpanel.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { HeaderComponent } from './components/shared/header/header.component';
import { customNotifierOptions } from './app.notify';
import { NotifierModule } from 'angular-notifier';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { NgxMaskModule } from 'ngx-mask'
import { ToastrModule } from 'ngx-toastr';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { routes } from './app.routes';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NotifyComponent } from './components/common/notify/notify.component';
import { MatToolbarModule, MatTableModule, MatNativeDateModule, } from '@angular/material';
import { ProposalListComponent } from './containers/proposal-list/proposal-list.component';
import { ProposalNewComponent } from './containers/proposal-new/proposal-new.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SidebarComponent,
    MainpanelComponent,
    ContentComponent,
    FooterComponent,
    HomeComponent,
    ProposalListComponent,
    ProposalNewComponent
  ],
  imports: [
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NotifierModule.withConfig(customNotifierOptions),
    routes,
    ToastrModule.forRoot(),
    NgxMaskModule.forRoot(),
    MatToolbarModule,
    MatNativeDateModule,
    MatTableModule  ],
  providers: [
    ProposalService,
    NotifyComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

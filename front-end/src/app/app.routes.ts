import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { ProposalNewComponent } from './containers/proposal-new/proposal-new.component';
import { ProposalListComponent } from './containers/proposal-list/proposal-list.component';

export const ROUTES: Routes = [
    { path: '', component: HomeComponent },
    { path: 'proposals', component: ProposalNewComponent },
    { path: 'proposals/find', component: ProposalListComponent }
];

export const routes: ModuleWithProviders = RouterModule.forRoot(ROUTES);

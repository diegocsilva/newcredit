import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';
import { ProposalListComponent } from './containers/proposal-list/proposal-list.component';
import { ProposalNewComponent } from './containers/proposal-new/proposal-new.component';

export const ROUTES: Routes = [
    { path: '', component: HomeComponent },
    { path: 'proposal', component: ProposalNewComponent },
    { path: 'find', component: ProposalListComponent }
];

export const routes: ModuleWithProviders = RouterModule.forRoot(ROUTES);

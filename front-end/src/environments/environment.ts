const api = 'http://localhost:8080';

export const environment = {
  production: false,
  proposal: {
    send: api + '/proposals',
    findByCpf: api + '/proposals'
  }
};

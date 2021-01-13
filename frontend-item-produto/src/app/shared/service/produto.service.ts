import { environment } from './../../../environments/environment.prod';
import { Produto } from './../entity/produto';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProdutoService {

  constructor(private httpCliente: HttpClient) { }

  produtoURL = environment.apiUrl + '/produto'

  getProdutos(){
<<<<<<< HEAD
    return this.httpCliente.get<Produto[]>(`${this.produtoURL}`)
=======
    return this.httpCliente.get<any>(`${this.produtoURL}`).pipe(take(1))
>>>>>>> branch 'master' of https://github.com/AdrianoModa/spring-angular-item-produto.git
  }

  getProdutosPorId(id: number) {
<<<<<<< HEAD
    return this.httpCliente.get<Produto[]>(`${this.produtoURL}/${id}`)
=======
    return this.httpCliente.get<any>(`${this.produtoURL}/${id}`).pipe(take(1))
>>>>>>> branch 'master' of https://github.com/AdrianoModa/spring-angular-item-produto.git
  }

  postProdutos(produto: any){
    return this.httpCliente.post(`${this.produtoURL}`, produto)
  }

  putProduto(produto: any){
    return this.httpCliente.put(`${this.produtoURL}/${produto.id}`, produto)
  }

  deleteProdutos(id: number) {
    return this.httpCliente.delete(`${this.produtoURL}/${id}`)
  }

}

package br.com.alura.mvc.mudi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Novo Kindle Paperwhite");
		pedido.setUrlImagem("https://m.media-amazon.com/images/I/71wpB3KIVKL._AC_SL1500_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/gp/product/B08N3J8GTX/ref=ox_sc_saved_title_3?smid=A1ZZFT5FULY4LN&psc=1");
		pedido.setDescricao("Novo Kindle Paperwhite: agora com tela de 6,8” e temperatura de luz ajustável");
		
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}
	
}

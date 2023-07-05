package com.crud.livraria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.livraria.models.Livro;
import com.crud.livraria.repository.LivrariaRepository;

@Controller
public class LivrariaController {
	
	@Autowired
	private LivrariaRepository lr;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/cadastrarfilmes", method=RequestMethod.GET)
	public String cadastrarfilmes() {
		return "content/cadastrar-livro";
	}
	
	@RequestMapping(value="/cadastrarfilmes", method=RequestMethod.POST)
	public String cadastrarfilmes(Livro livro) {
		lr.save(livro);
		return "redirect:/listarfilmes";
	}
	
	@RequestMapping("/listarfilmes")
	
	public ModelAndView listarfilmes() {
		
		ModelAndView mv = new ModelAndView("content/listar-livros");
		
		Iterable<Livro> livro = lr.findAll();
		mv.addObject("livros", livro);
		
		return mv;
		
	}
	
	@RequestMapping(value="/alterarfilmes/{codigolivro}", method=RequestMethod.GET)
	public ModelAndView formAlterarLivro(@PathVariable("codigolivro") long codigoLivro) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivro);
		
		ModelAndView mv = new ModelAndView("content/atualizar-livro");
		
		mv.addObject("livro", livro);
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/alterarfilmes/{codigolivro}", method=RequestMethod.POST)
	public String alterarLivro(@Validated Livro livro, BindingResult result, RedirectAttributes attributes) {
		
		lr.save(livro);
		return "redirect:/listarfilmes";
		
	}
	
	@RequestMapping("/confirmarExclusaolivros/{codigolivro}")
	public ModelAndView confirmarExclusaoLivro(@PathVariable("codigolivro") long codigoLivro) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivro);
		
		ModelAndView mv = new ModelAndView("content/excluir-livro");
		
		mv.addObject("livros", livro);
		
		return mv;
		
	}
	
	@RequestMapping("/excluirlivro")
	public String excluirLivro(long codigoLivros) {
		
		Livro livro = lr.findByCodigoLivro(codigoLivros);
		lr.delete(livro);
		
		return "redirect:/listarfilmes";
		
	}
	
}

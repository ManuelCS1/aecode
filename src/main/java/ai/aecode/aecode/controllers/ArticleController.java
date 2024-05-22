package ai.aecode.aecode.controllers;
import ai.aecode.aecode.dtos.ArticleDTO;
import ai.aecode.aecode.entities.Article;
import ai.aecode.aecode.services.IArticleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private IArticleService aS;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public void insert(@RequestParam("file") MultipartFile file, @RequestParam("articleDTO") String articleDTOJson) {

        try {
            ArticleDTO dto = objectMapper.readValue(articleDTOJson, ArticleDTO.class);
            byte[] fileContent = file.getBytes();
            dto.setArticle_pdf(fileContent);

            // Generar vista previa del PDF
            PDDocument document = PDDocument.load(file.getInputStream());
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String previewText = pdfStripper.getText(document); // Obtener el texto del PDF como vista previa
            document.close();

            // Aquí puedes mostrar 'previewText' en la interfaz de usuario para la vista previa

            ModelMapper modelMapper = new ModelMapper();
            Article article = modelMapper.map(dto, Article.class);
            aS.insert(article);
        } catch (IOException e) {
            // Manejo de excepciones al leer el archivo
            System.err.println("Error al leer el archivo PDF: " + e.getMessage());

            // Aquí puedes agregar la lógica para intentar guardar el archivo PDF en caso de error
            try {
                byte[] fileContent = file.getBytes();
                // Aquí puedes implementar la lógica para guardar el archivo en una ubicación específica o en una base de datos
            } catch (IOException ex) {
                System.err.println("Error al intentar guardar el archivo PDF: " + ex.getMessage());
            }
        }
    }

    @GetMapping
    public List<ArticleDTO> list() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArticleDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){aS.delete(id);}

    @GetMapping("/{id}")
    public ArticleDTO listId(@PathVariable("id")Integer id){
        ModelMapper m=new ModelMapper();
        ArticleDTO dto=m.map(aS.listId(id),ArticleDTO.class);
        return dto;
    }
    @PutMapping
    public void update(@RequestBody ArticleDTO dto) {
        ModelMapper m = new ModelMapper();
        Article a = m.map(dto, Article.class);
        aS.insert(a);
    }
}

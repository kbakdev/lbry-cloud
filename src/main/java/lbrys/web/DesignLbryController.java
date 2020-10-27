package lbrys.web;

import lbrys.Ingredient;
import lbrys.Ingredient.Type;
import lbrys.Lbry;
import lbrys.Order;
import lbrys.User;
import lbrys.data.IngredientRepository;
import lbrys.data.LbryRepository;
import lbrys.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignLbryController {

    private final IngredientRepository ingredientRepo;

    private LbryRepository lbryRepo;

    private UserRepository userRepo;

    @Autowired
    public DesignLbryController(
            IngredientRepository ingredientRepo,
            LbryRepository lbryRepo,
            UserRepository userRepo) {
        this.ingredientRepo = ingredientRepo;
        this.lbryRepo = lbryRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "design")
    public Lbry design() {
        return new Lbry();
    }

    @GetMapping
    public String showDesignForm(Model model, Principal principal) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }

        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        model.addAttribute("user", user);

        return "design";
    }

    @PostMapping
    public String processDesign(
            @Valid Lbry lbry, Errors errors,
            @ModelAttribute Order order) {

        if (errors.hasErrors()) {
            return "design";
        }

        Lbry saved = lbryRepo.save(lbry);
        order.addDesign(saved);

        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }

}
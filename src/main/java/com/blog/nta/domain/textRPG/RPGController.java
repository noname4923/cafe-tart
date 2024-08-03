package com.blog.nta.domain.textRPG;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * TRPG(Text Role Playing Game) 
 * 아이템 개념은 없다 (만약 인기가 좋으면 추가하자)
 * 스킬 인벤토리에 대한 개념만 있다
 * 능력치에 대한 상한선은 없다
 * 턴은 무조건 유저가 먼저라는 법칙은 없다 Common에서 재정의할 것(어떻게 규칙을 할지 내가 기획하기)
 * 스테이지별로 능력치를 이관해서 갖고 가되, 스테이지가 넘어간다고 해서 HP가 FULL이 되진 못한다
 *   - (스테이지 넘어갈때마다 HP가 FULL이 되는 옵션은 유료 기능으로 넣자)
 *   
 *   만들다 보니 재밌겠당..
 *   Flutter로 말아서 앱 화를 시킬 것 (광고 +, 유료 +)
 *   일단 웹 Ver에서 테스트
 *   잘 되면 게임만 따로 프로젝트화 하자..
 *   아 아니다 따로 프로젝트화 해서 MSA 구조로?
 *   
 *   + 이미지(디자인)
 *   + UI 
 *   + Icon(패시브 / 액티브)
 *   + 이펙트
 *   + 사운드
 *   + BGM
 *   
 *   필요해..
 *   
 * @author nta
 *
 */
@Log4j2
@Controller
@RequiredArgsConstructor
@RequestMapping("/RPG")
public class RPGController {

    private String gameMessage = "당신은 어두운 숲에서 깨어납니다. 북쪽으로 가는 길과 동쪽으로 가는 길이 보입니다.";
    private int playerHealth = 100;
    private int monsterHealth = 100;
    private boolean gameOver = false;

    /**
     * 최초 시작부
     * @param model
     * @return
     */
    @RequestMapping(value = "/selectRpgMainView", method = RequestMethod.GET)
    public String worldEntry(Model model) {
    	
    	/*
    	 * 사용자 Auth 체크 후, 
    	 *  DB 조회해서 유료 아이템 구매이력 있는 경우
    	 *  그에 맞는 값 세팅해 주고 게임 시작
    	 *    - 패시브 스킬 세트를 샀다면 패시브 스킬 +
    	 *      - 단, 스킬 인벤토리 초과 시에는 고를 수 있게 해주어야 한다
    	 *    - 액티브 스킬을 샀다면 액티브 스킬 +
    	 *      - 단, 스킬 인벤토리 초과 시에는 고를 수 있게 해주어야 한다
    	 *    - 돈을 샀다면 게임 내 재화 +
    	 *    - 능력치 펌핑 물약을 샀다면 해당 스테이터스 +
    	 *     
    	 */
    	
        model.addAttribute("gameMessage", gameMessage);
        model.addAttribute("playerHealth", playerHealth);
        model.addAttribute("monsterHealth", monsterHealth);
        model.addAttribute("gameOver", gameOver);
        return "rpg/main";
    }

    @RequestMapping(value = "/choosePath", method = RequestMethod.POST)
    public String choosePath(@RequestParam String path, Model model) {
        if (gameOver) {
        	return "redirect:/RPG/reset";
        }

        if ("north".equals(path)) {
            gameMessage = "북쪽으로 길을 따라가다 야생 괴물을 만나게 됩니다!";
            monsterHealth = 100;  // 괴물 체력 초기화
        } else if ("east".equals(path)) {
            gameMessage = "동쪽으로 길을 따라가면 평화로운 마을이 나옵니다.";
            monsterHealth = 0;  // 마을에서는 괴물 없음
            
            // 다음 스텝 로직 추가
        }

        model.addAttribute("gameMessage", gameMessage);
        model.addAttribute("playerHealth", playerHealth);
        model.addAttribute("monsterHealth", monsterHealth);
        model.addAttribute("gameOver", gameOver);

        return "rpg/main";
    }

    @RequestMapping(value = "/attack", method = RequestMethod.POST)
    public String attack(@RequestParam String action, Model model) {
        if (gameOver) {
        	return "redirect:/RPG/reset";
        }

        if ("attack".equals(action)) {
            monsterHealth -= 10;
            gameMessage = "당신은 괴물을 공격했습니다! 괴물의 체력: " + monsterHealth;
            if (monsterHealth <= 0) {
                gameMessage = "당신은 괴물을 물리쳤습니다! 게임이 끝났습니다.";
                gameOver = true;
            }
            
        } else if ("heal".equals(action)) {
            playerHealth += 10;
            gameMessage = "당신은 자신을 치유했습니다! 플레이어의 체력: " + playerHealth;
        }

        model.addAttribute("gameMessage", gameMessage);
        model.addAttribute("playerHealth", playerHealth);
        model.addAttribute("monsterHealth", monsterHealth);
        model.addAttribute("gameOver", gameOver);

        return "rpg/main";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String reset() {
        gameMessage = "당신은 어두운 숲에서 깨어납니다. 북쪽으로 가는 길과 동쪽으로 가는 길이 보입니다.";
        playerHealth = 100;
        monsterHealth = 100;
        gameOver = false;
        return "redirect:/RPG/selectRpgMainView";
    }
}

package com.blog.nta.domain.textRPG;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class RPGLocalDB {

	/* LocalDB 대용 적 DB Data */
	public static final Map<String, Map<String, Integer>> enemyData = new HashMap<>();
	
	/* + 패시브 스킬 세트에 대한 DB Data */
	/* + 액티브 스킬에 대한 DB Data */
	/* + 지형에 대한 DB Data */
	
	/** 
	 * Status 정렬 순서 
	 *  - AT : 물리 공격력
	 *  - DF : 물리 방어력
	 *  - CH : 크리티컬 히트율
	 *  - EV : 회피율
	 *  - LK : 행운
	 *  
	 *   + 마법 공격력 / 마법 저항력 
	 *   + 명중률
	 *   + 지형 적응률(지형에 대한 DB도 필요)
	 */
	public static final List<String> STATUS = List.of("at", "df", "ch", "ev", "lk");

	@PostConstruct
	public void init() {
		enemyData.put("몹1", new HashMap<>(Map.of("at", 10, "df", 10, "ch", 1, "ev", 5, "lk", 0)));
		enemyData.put("몹2", new HashMap<>(Map.of("at", 10, "df", 10, "ch", 1, "ev", 5, "lk", 0)));
		enemyData.put("몹3", new HashMap<>(Map.of("at", 10, "df", 10, "ch", 1, "ev", 5, "lk", 0)));
	}
	
	/*
	 * 생성자
	 */
    public RPGLocalDB(Map<String, Map<String, Integer>> testData) {
    	enemyData.clear();
    	enemyData.putAll(testData);
    }
	
	/*
	 * GET Categories
	 */
	public List<String> getCategories() {
        return STATUS;
    }

	/* Brand Data 조회 */
	public Map<String, Map<String, Integer>> getBrandData() {
		return enemyData;
	}
	
	/* 브랜드 및 상품 추가 */
	public void addBrand(Map<String, Map<String, Integer>> newBrandData) {
		enemyData.putAll(newBrandData);
    }
	
	/* 브랜드 수정 */
    public void updateBrand(Map<String, Map<String, Integer>> updatedBrandData) {
    	
        for (String brand : updatedBrandData.keySet()) {
        	// 기존에 브랜드가 존재하는 경우 
            if (enemyData.containsKey(brand)) {
            	
            	// 기존 데이터
                Map<String, Integer> existingData = enemyData.get(brand);
                // 신규 데이터 
                Map<String, Integer> newData = updatedBrandData.get(brand);
                
                for (String category : newData.keySet()) {
                    existingData.put(category, newData.get(category));
                }
                enemyData.put(brand, existingData);
                
            // 기존에 브랜드가 존재하지 않는 경우 
            } else {
                throw new IllegalArgumentException("존재하지 않는 브랜드입니다: " + brand);
            }
        }
    }
    
    /* Brand 삭제 */
    public void deleteBrand(String brand) {
        if (enemyData.containsKey(brand)) {
        	enemyData.remove(brand);
        } else {
            throw new IllegalArgumentException("존재하지 않는 브랜드입니다: " + brand);
        }
    }
}

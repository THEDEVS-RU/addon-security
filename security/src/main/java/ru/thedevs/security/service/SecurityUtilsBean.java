package ru.thedevs.security.service;

import ru.thedevs.entity.Phone;
import io.jmix.core.UnconstrainedDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SecurityUtilsBean {
  @Autowired
  private UnconstrainedDataManager dataManager;

  /**
   * Простой поиск телефона, если не существует, тогда вернет новый, без сохранения
   *
   * @param phoneLong Телефон лонг
   * @param fetchName фетчплан
   * @return сущность телефона
   */
  public Phone getPhone(Long phoneLong, String fetchName) {
    if (phoneLong == null){
      return null;
    }
    Phone phone = searchPhoneExist(phoneLong, fetchName);
    if (phone == null) {
      phone = dataManager.create(Phone.class);
      phone.setNumber(phoneLong);
    }
    return phone;
  }

  private Phone searchPhoneExist(Long phoneLong, String fetchName) {
    return dataManager.load(Phone.class).query("e.number = :curNumber")
         .parameter("curNumber", phoneLong)
         .fetchPlan(fetchName)
         .optional().orElse(null);
  }
}
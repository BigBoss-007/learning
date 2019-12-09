package com.zhangln.sms.sms.service.impl;

import com.zhangln.sms.sms.entity.RegUserEntity;
import com.zhangln.sms.sms.mapper.RegUserMapper;
import com.zhangln.sms.sms.service.IRegUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 注册用户，即允许使用推送服务的账号 服务实现类
 * </p>
 *
 * @author sherry
 * @since 2019-12-09
 */
@Service
public class RegUserServiceImpl extends ServiceImpl<RegUserMapper, RegUserEntity> implements IRegUserService {

}

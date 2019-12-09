package com.zhangln.sms.sms.service.impl;

import com.zhangln.sms.sms.entity.AccessTokenEntity;
import com.zhangln.sms.sms.mapper.AccessTokenMapper;
import com.zhangln.sms.sms.service.IAccessTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * token验证表 服务实现类
 * </p>
 *
 * @author sherry
 * @since 2019-12-09
 */
@Service
public class AccessTokenServiceImpl extends ServiceImpl<AccessTokenMapper, AccessTokenEntity> implements IAccessTokenService {

}

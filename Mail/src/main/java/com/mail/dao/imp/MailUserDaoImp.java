package com.mail.dao.imp;

import org.springframework.stereotype.Service;

import com.mail.dao.MailUserDao;
import com.mail.dao.basedao.MailBaseDaoImp;
import com.mail.domain.MailUserDomain;
@Service
public class MailUserDaoImp extends MailBaseDaoImp<MailUserDomain> implements MailUserDao {

}

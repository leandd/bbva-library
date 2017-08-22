package com.atsistemas.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.atsistemas.beans.Book;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.DateTimeZoneTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.LocalDateTimeTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.LocalDateTranslatorFactory;
import com.googlecode.objectify.impl.translate.opt.joda.ReadableInstantTranslatorFactory;

public class ObjectifyConfig implements ServletContextListener {

    static {
        // Add translators for Joda objects

        ObjectifyService.factory().getTranslators()
                .add(new ReadableInstantTranslatorFactory());
        ObjectifyService.factory().getTranslators()
                .add(new LocalDateTranslatorFactory());
        ObjectifyService.factory().getTranslators()
                .add(new LocalDateTimeTranslatorFactory());
        ObjectifyService.factory().getTranslators()
                .add(new DateTimeZoneTranslatorFactory());

        // TODO: Add and register each data bean here
        ObjectifyService.register(Book.class);
    }

    @Override
    public void contextInitialized(final ServletContextEvent sce) {
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
    }
}
